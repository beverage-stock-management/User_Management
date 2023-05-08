package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User_db") //collection name
@Data //to avoid using getter and setter
@AllArgsConstructor //to avoid using constructor
public class User {
    @Id //define primary key
    private int userId;
    private String userName;
    private String address;


}
