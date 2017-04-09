package tv.anypoint.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kwlee on 15. 9. 22.
 */
@Data
public class ImpressionLogGenre implements Serializable {

    private static final long serialVersionUID = -2221200772435212034L;

    private int id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date impressionTime;

    private int totalImpression;

    private int totalAmount;

    private int serviceOperator;

    private int programProvider;

    private int inventory;

    private int deviceTotalImpression;
}
