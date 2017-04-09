package tv.anypoint.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kwlee on 15. 9. 22.
 */
public class ImpressionLogCampaignGenre implements Serializable {

    private static final long serialVersionUID = -5090718616687586939L;

    private int id;

    private long campaign;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date impressionTime;

    private int totalImpression;

    private int totalAmount;

    private int serviceOperator;

    private int programProvider;

    private int inventory;

    private int deviceTotalImpression;

}
