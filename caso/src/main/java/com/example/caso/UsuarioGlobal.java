package com.example.caso;

public class UsuarioGlobal {
    private static String nombreUsuario;

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        UsuarioGlobal.nombreUsuario = nombreUsuario;
    }
}