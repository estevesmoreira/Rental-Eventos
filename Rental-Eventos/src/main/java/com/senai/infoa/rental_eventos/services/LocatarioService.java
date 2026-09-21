package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.infoa.rental_eventos.dto.LocatarioRequestDTO;
import com.senai.infoa.rental_eventos.dto.LocatarioResponseDTO;
import com.senai.infoa.rental_eventos.models.Locatario;
import com.senai.infoa.rental_eventos.repositories.LocatarioRepository;

@Service
public class LocatarioService {

    @Autowired
    private LocatarioRepository locatarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Long contarLocatario() {
        return locatarioRepository.count();
    }

    public Locatario buscarLocatario(Long id) {
        return locatarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Locatário não encontrado."
        ));
    }

    public LocatarioResponseDTO buscarLocatarioDTO(Long id) {
        Locatario locatario = buscarLocatario(id);

        return new LocatarioResponseDTO(
                locatario.getId(),
                locatario.getNome(),
                locatario.getEmail()
        );
    }

    public List<LocatarioResponseDTO> listarLocatario() {
        return locatarioRepository.findAll()
                .stream()
                .map(locatario -> new LocatarioResponseDTO(
                locatario.getId(),
                locatario.getNome(),
                locatario.getEmail()
        ))
                .toList();
    }

    public Boolean deletarLocatario(Long id) {
        if (locatarioRepository.existsById(id)) {
            locatarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public LocatarioResponseDTO cadastrarLocatario(LocatarioRequestDTO dto) {
        if (locatarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "E-mail já cadastrado."
            );
        }

        Locatario locatario = new Locatario();
        locatario.setNome(dto.nome());
        locatario.setEmail(dto.email());
        locatario.setSenha(passwordEncoder.encode(dto.senha()));

        Locatario salvo = locatarioRepository.save(locatario);

        return new LocatarioResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail()
        );
    }

    public Locatario login(String email, String senha) {
        Locatario locatario = locatarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "E-mail ou senha incorretos."
        ));

        if (!passwordEncoder.matches(senha, locatario.getSenha())) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "E-mail ou senha incorretos."
            );
        }

        return locatario;
    }

}
