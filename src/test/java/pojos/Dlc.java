package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dlc {
    private String description;
    private String dlcName;
    private Boolean isDlcFree;
    private Integer price;
    private Integer rating;
    private SimilarDlc similarDlc;
}
