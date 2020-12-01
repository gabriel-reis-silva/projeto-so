package com.mycompany.ac3.sistemas.operacionais;

import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;

public class Network {

    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    public List<NetworkIF> netw = hal.getNetworkIFs();
    

    public Long bytesRec() {
        netw.get(0).updateAttributes();
        Long rec = (netw.get(0).getBytesRecv());
        return rec;
    }
    
    public Long bytesEnv() {
        netw.get(0).updateAttributes();
        Long sent = (netw.get(0).getBytesSent());
        return sent;
    }
}
