package kttech.QrCodeGenerator.service;

import kttech.QrCodeGenerator.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();

}
