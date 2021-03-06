package com.spring.henallux.demo.dataAccess.util;

import com.spring.henallux.demo.dataAccess.entity.UserEntity;
import com.spring.henallux.demo.dataAccess.entity.UtilisateurEntity;
import com.spring.henallux.demo.model.User;
import com.spring.henallux.demo.model.Utilisateur;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

@Service
public class ProviderConverter {
    private Mapper mapper = new DozerBeanMapper();

    public UserEntity userModelToUserEntity(User user) {
        return mapper.map(user, UserEntity.class);
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        return mapper.map(userEntity, User.class);
    }

    public UtilisateurEntity utilisateurModelToUtilisateurEntity(Utilisateur utilisateur) {
        UtilisateurEntity utilisateurEntity = new UtilisateurEntity();

        utilisateurEntity.setPassword(utilisateur.getPassword());
        utilisateurEntity.setUsername(utilisateur.getUsername());
        utilisateurEntity.setAccountNonExpired(true);
        utilisateurEntity.setAccountNonLocked(true);
        utilisateurEntity.setAuthorities("ROLE_ADMIN");
        utilisateurEntity.setCredentialsNonExpired(true);
        utilisateurEntity.setEnabled(true);

        return utilisateurEntity;
    }

    public Utilisateur utilisateurEntityToUtilisateurModel(UtilisateurEntity utilisateurEntity) {
        return mapper.map(utilisateurEntity, Utilisateur.class);
    }
}
