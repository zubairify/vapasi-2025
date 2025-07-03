import com.tw.bean.Vehicle;
import com.tw.dao.VehicleDao;
import com.tw.dao.VehicleDaoImpl;
import com.tw.service.VehicleService;
import com.tw.service.VehicleServiceImpl;

public class TestVehicleService {
    public static void main(String[] args) {
        VehicleDao vehicleDao = new VehicleDaoImpl();
        VehicleService vehicleService = new VehicleServiceImpl(vehicleDao);

        vehicleService.add(new Vehicle(106,"Astor","MG","Red","Battery",1250000));

//        vehicleService.findAll().forEach(System.out::println);

        System.out.println(vehicleService.findByCode(102));
    }
}
