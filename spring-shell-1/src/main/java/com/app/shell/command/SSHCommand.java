package com.app.shell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import jakarta.validation.constraints.Size;

@ShellComponent
public class SSHCommand {

    @ShellMethod(value = "connect to remote server")
    public void ssh(@ShellOption(value = "--s", defaultValue = "default-server") String remoteServer){
    
    }

    @ShellMethod(value = "add keys")
    public void sshAdd(@ShellOption(value = "--k", arity = 2) String[] keys){
    
    }

    @ShellMethod(value = "sign in")
    public void sshLogin(@ShellOption(value = "--r") boolean rememberMe){
    
    }

    @ShellMethod(value = "ssh agent")
    public void sshAgent(
            @ShellOption(value = "--a")
            @Size(min = 2, max = 10) String agent){
    
    }
}