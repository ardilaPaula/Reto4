/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domingo_Reto3.Reto3.controlador;

import Domingo_Reto3.Reto3.Modelo.Room;
import Domingo_Reto3.Reto3.servicios.ServiciosRoom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorRoom {
    @Autowired
    private ServiciosRoom servicio;
    @GetMapping("/all")
    public List<Room> getRoom(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") int roomId) {
        return servicio.getRoom(roomId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room room) {
        return servicio.save(room);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room room) {
        return servicio.update(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int roomId) {
        return servicio.deleteRoom(roomId);
    }
      
}
