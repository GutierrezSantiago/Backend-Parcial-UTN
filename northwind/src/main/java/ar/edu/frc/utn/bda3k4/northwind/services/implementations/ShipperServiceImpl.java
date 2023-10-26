package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.Shipper;
import ar.edu.frc.utn.bda3k4.northwind.repositories.ShipperRepository;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.ShipperService;

import java.util.List;

public class ShipperServiceImpl implements ShipperService {

    private final ShipperRepository shipperRepository;

    public ShipperServiceImpl(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @Override
    public Shipper add(Shipper entity) {
        return this.shipperRepository.save(entity);
    }

    @Override
    public Shipper update(Shipper entity) {
        Shipper shipper = this.shipperRepository.findById(entity.getId()).orElseThrow(()->
                new IllegalArgumentException("Shipper not found"));
        shipper.setCompanyName(entity.getCompanyName());
        shipper.setPhone(entity.getPhone());
        return this.shipperRepository.save(shipper);
    }

    @Override
    public Shipper delete(Integer id) {
        Shipper shipper = this.shipperRepository.findById(id).orElse(null);
        if(shipper != null){
            this.shipperRepository.delete(shipper);
        }
        return shipper;
    }

    @Override
    public Shipper findById(Integer id) {
        return this.shipperRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Shipper not found"));
    }

    @Override
    public List<Shipper> findAll() {
        return null;
    }
}
