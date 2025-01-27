package kttech.QrCodeGenerator.controller;

import com.google.zxing.WriterException;
import kttech.QrCodeGenerator.models.User;
import kttech.QrCodeGenerator.service.UserService;
import kttech.QrCodeGenerator.utils.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() throws IOException, WriterException {
        //Get all records in the database
        List<User> users = userService.getAllUsers();
        //For each record in the database generate a QR code
        if (!users.isEmpty()) {
            for(User user : users) {
                QRCodeGenerator.generateQRCode(user);
            }
        }
        return ResponseEntity.ok(userService.getAllUsers());
    }



    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }





}
