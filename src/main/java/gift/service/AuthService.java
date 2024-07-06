package gift.service;

import gift.auth.JwtUtil;
import gift.domain.User;
import gift.dto.requestDTO.UserLoginRequestDTO;
import gift.dto.requestDTO.UserSignupRequestDTO;
import gift.dto.responseDTO.UserResponseDTO;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public UserResponseDTO register(UserSignupRequestDTO userSignupRequestDTO) {
        String token = jwtUtil.createToken(userSignupRequestDTO.email(), userSignupRequestDTO.role());
        return new UserResponseDTO(token);
    }

    public UserResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) {
        User user = UserLoginRequestDTO.toEntity(userLoginRequestDTO);
        if (!user.getPassword().equals(userLoginRequestDTO.password())) {
            throw new NoSuchElementException("회원의 정보가 일치하지 않습니다.");
        }
        String token = jwtUtil.createToken(user.getEmail(), user.getRole());
        return new UserResponseDTO(token);
    }
}
