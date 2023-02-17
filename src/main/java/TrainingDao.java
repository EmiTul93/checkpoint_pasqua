import java.sql.*;

public class TrainingDao {

    private final String ALL_DATA_FROM_TRAINING = "SELET TS.*, TSD.* FROM TRAINING_SESSION TS FULL JOIN TRAINING_SESSION_DATA TSD ON ID_TRAINING_SESSION = ID_TRAINING_SESSION_DATA"  ;

    int rs

    public TrainingDao getTraningSessionDataByTrainingId(Integer trainingId){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer","passwordhere");
            Statement s = c.createStatement();
            rs = s.executeUpdate(ALL_DATA_FROM_TRAINING);



    } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
