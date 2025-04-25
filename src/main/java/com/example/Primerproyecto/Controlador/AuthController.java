		package com.example.Primerproyecto.Controlador;
	
	
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.*;
	
	import com.example.Primerproyecto.Servicio.AuthService;
	import com.example.Primerproyecto.Servicio.UserService;
	import com.example.Primerproyecto.dtos.LoginUserDto;
	import com.example.Primerproyecto.dtos.NewUserDto;
	import com.example.Primerproyecto.entidad.User;
	
	import java.util.HashMap;
	import java.util.Map;
	
	import javax.validation.Valid;
	
	@RestController
	@RequestMapping("/auth")
	public class AuthController {
	
	    private final AuthService authService;
	    private final UserService userService;
	
	    @Autowired
	    public AuthController(AuthService authService, UserService userService) {
	        this.authService = authService;
	        this.userService = userService;
	    }
	
	    @PostMapping("/login")
	    public ResponseEntity<?> login(@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult){
	        if (bindingResult.hasErrors()){
	            return ResponseEntity.badRequest().body("Revise sus credenciales");
	        }
	
	        try {
	            String jwt = authService.authenticate(loginUserDto.getUserName(), loginUserDto.getPassword());
	            User user = userService.getByUserName(loginUserDto.getUserName());
	
	            Map<String, Object> response = new HashMap<>();
	            response.put("token", jwt);
	            response.put("role", user.getRole().getName().name()); // Devuelve ROLE_ADMIN, ROLE_USER, etc.
	
	            return ResponseEntity.ok(response);
	        } catch (Exception e){
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	
	
	    @PostMapping("/register")
	    public ResponseEntity<String> register(@Valid @RequestBody NewUserDto newUserDto, BindingResult bindingResult){
	        if (bindingResult.hasErrors()){
	            return ResponseEntity.badRequest().body("Revise los campos");
	        }
	        try {
	            authService.registerUser(newUserDto);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Registrado");
	        } catch (IllegalArgumentException e){
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	
	    @GetMapping("/check-auth")
	    public ResponseEntity<String> checkAuth(){
	            return ResponseEntity.ok().body("Autenticado");
	    }
	}
