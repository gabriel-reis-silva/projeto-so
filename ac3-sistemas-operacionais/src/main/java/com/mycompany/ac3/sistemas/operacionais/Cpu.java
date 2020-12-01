/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ac3.sistemas.operacionais;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author gabsg
 */
public class Cpu {
    
     private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    private CentralProcessor cpu = hal.getProcessor();
    private long [] oldTicks = cpu.getSystemCpuLoadTicks();
    
    
    public CentralProcessor cpuInfo() {
        return cpu;
    }
    
    private long [] oldticks;
    
    public Cpu(HardwareAbstractionLayer hal) {
        this.cpu = hal.getProcessor();
        oldticks = cpu.getSystemCpuLoadTicks();
    }
    
    public double cpuUsage() {
        double d = cpu.getSystemCpuLoadBetweenTicks(oldTicks);
        return (100d * d);
    }

    @Override
    public String toString() {
        return  String.format("%.2f",cpu.getSystemCpuLoadBetweenTicks(oldTicks) *100d);
    }
    
}
