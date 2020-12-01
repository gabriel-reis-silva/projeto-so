/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ac3.sistemas.operacionais;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author gabsg
 */
public class Main {

    public static void main(String[] args) {
        Connection conn = new Connection();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        Cpu cpu = new Cpu(hal);
        Network net = new Network();
        int delay = 5000;   // delay de 5 seg.
        int interval = 5000;  // intervalo de 1 seg.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Uso de cpu " + cpu.cpuUsage());
                System.out.println("Bytes recebidos: " + net.bytesRec());
                System.out.println("Bytes enviados: " + net.bytesEnv());
                
                JdbcTemplate con = new JdbcTemplate(conn.getDataSource());
                String insertStatement = "insert into leitura2 (cpuLeitura, bytesRcv, bytesSnd) values (?, ?, ?)";
                con.update(insertStatement, cpu.cpuUsage(), net.bytesRec(), net.bytesEnv());
            }
        }, 2000, 2000);

    }

}
