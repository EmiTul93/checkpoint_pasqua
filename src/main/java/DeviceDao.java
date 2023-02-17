

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDao {

    private final String ALL_DEVICES_WITH_HR_GPS = "SELET * FROM DEVICE WHERE 'DEVICE_HAS_GPS <>? AND DEVICE_HEARTRATE <>? AND 'USERNAME' = ?" ;

    Device device = null;
    ResultSet rs =null;

    List<Device> list = new ArrayList<>();
    public List<Device> getAllDeviceWIthHearthRateAndGps(String username) throws SQLException {

        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "developer", "passwordhere");
            PreparedStatement s = c.prepareStatement(ALL_DEVICES_WITH_HR_GPS);
            s.setInt(1, 0);
            s.setInt(2, 0);
            s.setString(3, "paolo");
            rs = s.executeQuery();
            while (rs.next()) {
                Device device = new Device(rs.getString("devicePartNumber"),
                        rs.getString("deviceManufacturer"),
                        rs.getString("deviceModel"),
                        rs.getShort("deviceHasGps"),
                        rs.getShort("deviceHasHeartRate"),
                        rs.getString("username"));
                list.add(device);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    }


