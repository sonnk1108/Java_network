package Model;

import java.io.Serializable;

public class global implements Serializable {
	private int NewConfirmed;
	private int	TotalConfirmed;
	private int	NewDeaths;
	private int	TotalDeaths;
	private int	NewRecovered;
	private int TotalRecovered;
	public int getNewConfirmed() {
		return NewConfirmed;
	}
	public int getTotalConfirmed() {
		return TotalConfirmed;
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
}
