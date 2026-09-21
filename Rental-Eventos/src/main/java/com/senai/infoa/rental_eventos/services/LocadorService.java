package com.senai.infoa.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.infoa.rental_eventos.dto.LocadorRequestDTO;
import com.senai.infoa.rental_eventos.dto.LocadorResponseDTO;
import com.senai.infoa.rental_eventos.models.Locador;
import com.senai.infoa.rental_eventos.repositories.LocadorRepository;

@Service
public class LocadorService {

    @Autowired
    private LocadorRepository locadorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Long contarLocador() {
        return locadorRepository.count();
    }

    public Locador buscarLocador(Long id) {
        return locadorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Locador não encontrado."
        ));
    }

    public LocadorResponseDTO buscarLocadorDTO(Long id) {
    Locador locador = buscarLocador(id);

    return new LocadorResponseDTO(
            locador.getId(),
            locador.getNome(),
            locador.getEmail()
    );
}

    public List<LocadorResponseDTO> listarLocador() {
        return locadorRepository.findAll()
                .stream()
                .map(locador -> new LocadorResponseDTO(
                locador.getId(),
                locador.getNome(),
                locador.getEmail()
        ))
                .toList();
    }

    public Boolean deletarLocador(Long id) {
        if (locadorRepository.existsById(id)) {
            locadorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public LocadorResponseDTO cadastrarLocador(LocadorRequestDTO dto) {
        if (locadorRepository.findByEmail(dto.email()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "E-mail já cadastrado."
            );
        }

        Locador locador = new Locador();
        locador.setNome(dto.nome());
        locador.setEmail(dto.email());
        locador.setSenha(passwordEncoder.encode(dto.senha()));

        Locador salvo = locadorRepository.save(locador);

        return new LocadorResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail()
        );
    }

    public Locador login(String email, String senha) {
        Locador locador = locadorRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "E-mail ou senha incorretos."
        ));

        if (!passwordEncoder.matches(senha, locador.getSenha())) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "E-mail ou senha incorretos."
            );
        }

        return locador;
    }

}
