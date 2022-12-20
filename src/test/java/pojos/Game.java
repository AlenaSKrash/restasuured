package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private String company;
    private String description;
    private List<Dlc> dlcs;
    private Integer gameId;
    private String genre;
    private Boolean isFree;
    private Integer price;
    private Date publish_date;
    private Integer rating;
    private Boolean requiredAge;
    private Requirements requirements;
    private List<String> tags;
    private String title;
}
