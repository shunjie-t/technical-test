package com.techincaltest.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchandiseRequest {
	private long merchandiseId;
	private String merchandiseName;
	private String merchandiseDescription;
	private double merchandisePrice;
	private String merchandiseImage;
}
