package tv.anypoint.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kwlee on 15. 9. 22.
 */
@Data
public class ImpressionLogRegion implements Serializable {

    private static final long serialVersionUID = -770949202803046607L;

    private int id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date impressionTime;

    private int totalImpression;

    private int totalAmount;

    private int serviceOperator;

    private int region1;

    private int region2;

    private int region3;

    private int region4;

    private int zipCode;

    private int inventory;

    private int deviceTotalImpression;
}
