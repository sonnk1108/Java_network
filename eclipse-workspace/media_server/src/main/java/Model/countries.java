package Model;

import java.io.Serializable;

public class countries implements Serializable {
	private String Country;
	private String CountryCode;
	private String Slug;
	private int NewConfirmed;
	private int NewDeaths;
	private int TotalConfirmed;
	public int getTotalConfirmed() {
		return TotalConfirmed;
	}
	private int TotalDeaths;
	private int NewRecovered;
	private int TotalRecovered;
	public String getCountry() {
		return Country;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public String getSlug() {
		return Slug;
	}
	public int getNewConfirmed() {
		return NewConfirmed;
	}
	public int getNewDeaths() {
		return NewDeaths;
	}
	public int getTotalDeaths() {
		return TotalDeaths;
	}
	public int getNewRecovered() {
		return NewRecovered;
	}
	public int getTotalRecovered() {
		return TotalRecovered;
	}
	public String getDate() {
		return Date;
	}
	public Object getPremium() {
		return Premium;
	}
	private String Date;
	private Object Premium;
}
