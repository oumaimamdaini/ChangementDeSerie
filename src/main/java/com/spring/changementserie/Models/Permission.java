package com.spring.changementserie.Models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    technicienPrep_READ("technicienPrep:read"),

    technicienPrep_CREATE("technicienPrep:create"),
    technicienCur_READ("technicienCur:read"),

    technicienCur_CREATE("technicienCur:create"),
    technicienPrev_READ("technicienPrev:read"),

    technicienPrev_CREATE("technicienPrev:create"),
    responsableMéthode_CREATE("responsableMéthode:create"),
    responsableMéthode_READ("responsableMéthode:read"),
    chefSecteurCur_CREATE("chefSecteurCur:create"),
    chefSecteurCur_READ("chefSecteurCur:read");


    @Getter
    private final String permission;
}
