package com.company.users;

import java.io.IOException;
import java.net.ServerSocket;

import static com.company.consts.Constants.SERVER_SOCKET;

public class Server {

    ServerSocket serverSocket;
    {
        try {
            serverSocket = new ServerSocket(Integer.getInteger(SERVER_SOCKET));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
