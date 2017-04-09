package tv.anypoint.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kwlee on 15. 9. 22.
 */
@Data
public class ImpressionLogCampaignPeriod implements Serializable {

    private static final long serialVersionUID = 8908531957797442591L;

    private int id;

    private long campaign;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date impressionTime;

    private int totalImpression;

    private int totalAmount;

    private int serviceOperator;

    private int inventory;

    private int deviceTotalImpression;

}
