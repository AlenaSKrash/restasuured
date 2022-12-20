package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Requirements {
    private Integer hardDrive;
    private String osName;
    private Integer ramGb;
    private String videoCard;
}
