package com.victoryfarmskenya.inventory.controllers;

import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victoryfarmskenya.inventory.models.AuthenticationResponse;
import com.victoryfarmskenya.inventory.models.Item;
import com.victoryfarmskenya.inventory.models.ItemRequest;
import com.victoryfarmskenya.inventory.models.Items;
import com.victoryfarmskenya.inventory.models.LocIt;
import com.victoryfarmskenya.inventory.models.Locations;
import com.victoryfarmskenya.inventory.models.Purchases;
import com.victoryfarmskenya.inventory.models.ServedItems;
import com.victoryfarmskenya.inventory.models.ServedRequests;
import com.victoryfarmskenya.inventory.models.Users;
import com.victoryfarmskenya.inventory.security.JwtUtil;
import com.victoryfarmskenya.inventory.services.ItemService;
import com.victoryfarmskenya.inventory.services.MyUserDetailsService;
import com.victoryfarmskenya.inventory.services.UserService;

@CrossOrigin(origins = "*", maxAge=3600)
@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	UserService us;
	@Autowired
	private AuthenticationManager am;
	@Autowired
	private MyUserDetailsService userdetails;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ItemService is;

	@GetMapping(value = "/getlocit")
	public ResponseEntity<?> hello() {
		List<Items> items = is.findAllItems();
		List<Locations> locations = is.findAllLocations();
		return ResponseEntity.ok(new LocIt(items, locations));
	}

	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@RequestBody Items item) throws Exception {
		is.saveItems(item);

		return ResponseEntity.ok(new String("Added"));
	}

	@PostMapping("/addlocation")
	public ResponseEntity<?> addLocation(@RequestBody Locations location) throws Exception {

		is.saveLocation(location);
		return ResponseEntity.ok(new String("Added"));
	}

	@GetMapping(value = "/admin")
	public void admin() {
		Users a = new Users();
		a.setEmail("Admin@egerton.ac.ke");
		a.setPassword("@Admin");
		a.setRole("Admin");
		a.setNames("Admin");
		us.save(a);
	}

	@PostMapping(value = "/auth/login")
	public ResponseEntity<?> au(@RequestBody Users user) throws Exception {

		try {
			am.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorect username or password");
		}
		final Users users = (Users) userdetails.loadUserByUsername(user.getUsername());

		final String jwt = jwtTokenUtil.generateToken(users);
		return ResponseEntity.ok(new AuthenticationResponse(jwt, users));
	}

	@PostMapping(value = "/auth/register")
	public ResponseEntity<?> register(@RequestBody Users users) throws Exception {
		if (us.existsByEmail(users.getEmail())) {
			return ResponseEntity.badRequest().body(new String("User with the email already exists"));
		}
		users.setRole("Employee");

		users.setPassword(passwordEncoder.encode(users.getPassword()));

		return ResponseEntity.ok(new String("Registration Successful"));
	}

	@PostMapping(value = "/assets")
	public ResponseEntity<?> add(@RequestParam("image") MultipartFile file, @RequestParam("purchases") String purchases)
			throws Exception {
		Purchases p = new ObjectMapper().readValue(purchases, Purchases.class);

		is.savePurchase(p);
		if (is.existsByItem(p.getItem())) {

			is.updateItem(p.getQnty(), is.findByItem(p.getItem()).getId());
		} else {
			Item i = new Item();
			i.setItem(p.getItem());
			i.setQnty(p.getQnty());
			i.setUnitprice(p.getUnitprice());
			i.setLocation(p.getLocation());
			i.setPicture(file.getBytes());
			i.setDescription(p.getDescription());
			i.setExtension(FilenameUtils.getExtension(file.getOriginalFilename()));
			;
			is.saveItem(i);
		}
		return ResponseEntity.ok(new String("Added Successful"));
	}

	@GetMapping("/items")
	public ResponseEntity<List<Item>> getItems() throws Exception {
		List<Item> items = is.findAllItem();
		for (Item item : items) {
			tobase64(item);
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

	@PostMapping("/request")
	public ResponseEntity<?> saveRequests(@RequestBody ItemRequest ir) throws Exception {
		ir.setComplete(false);
		is.saveRequest(ir);

		return ResponseEntity.ok(new String("Request Sent"));
	}

	@GetMapping("/request")
	public ResponseEntity<List<ItemRequest>> getRequests() throws Exception {
		List<ItemRequest> items = is.findAllRequest();

		return new ResponseEntity<List<ItemRequest>>(items, HttpStatus.OK);
	}

	@PostMapping("/updaterequest")
	public ResponseEntity<?> updateRequests(@RequestBody int id) throws Exception {
		is.updateComplete(id);
		return ResponseEntity.ok(new String("Request Updated"));
	}

	@PostMapping("/serverequest")
	public ResponseEntity<?> servedRequests(@RequestBody ServedRequests sr) throws Exception {
		is.saveServedRequest(sr);
		is.itemUpdate(sr.getQnty(), is.findByItem(sr.getItem()).getId());
		if (is.existsBySItem(sr.getItem())) {

			is.updateSItem(sr.getQnty(), is.findBySItem(sr.getItem()).getId());
		} else {
			ServedItems si = new ServedItems();
			si.setItem(sr.getItem());
			si.setQnty(sr.getQnty());
			is.saveServedItems(si);
		}
		
		return ResponseEntity.ok(new String("Request Completed"));
	}

	@DeleteMapping("/serverequest/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		is.deleteItemRequest(id);
		return new ResponseEntity<String>("Completed", HttpStatus.OK);

	}

	@GetMapping("/completerequests")
	public ResponseEntity<List<ServedRequests>> getall() throws Exception {
		List<ServedRequests> items = is.findAllServedRequest();

		return new ResponseEntity<List<ServedRequests>>(items, HttpStatus.OK);
	}
	@GetMapping("/completerequests1")
	public ResponseEntity<?> getSI(){
		List<ServedItems> items = is.getServedItems();

		return new ResponseEntity<List<ServedItems>>(items, HttpStatus.OK);
	}
	public Item tobase64(Item item) {
		String extension = item.getExtension();

		byte[] blobAsBytes = item.getPicture();
		String base64image = Base64.getEncoder().encodeToString(blobAsBytes);

		item.setBase64image("data:image/" + extension + ";base64," + base64image);

		return item;
	}
}
