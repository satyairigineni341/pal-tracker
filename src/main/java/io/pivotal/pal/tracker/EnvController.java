package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    @Value("${PORT:NOT SET}") String port;
    @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit;
    @Value("${CF_INSTANCE_INDEX:NOT SET}") String cFInstanceIndex;
    @Value("${CF_INSTANCE_ADDR:NOT SET}") String cFInstanceAddr;

    public EnvController() {

    }
    public EnvController(String port, String memoryLimit, String cFInstanceIndex, String cFInstanceAddr) {
        this.port=port;
        this.memoryLimit=memoryLimit;
        this.cFInstanceIndex=cFInstanceIndex;
        this.cFInstanceAddr=cFInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
      Map map=new HashMap();
      map.put("PORT",this.port);
      map.put("MEMORY_LIMIT",this.memoryLimit);
      map.put("CF_INSTANCE_INDEX",this.cFInstanceIndex);
      map.put("CF_INSTANCE_ADDR",this.cFInstanceAddr);
      return map;
    }
}
