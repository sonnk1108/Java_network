package Danh_ba_dien_thoai;

public interface Registry_itf {
	public void add(Person p);
	public String getPhone(String name);
	public Iterable<Person> getAll();
	public Person search(String name);

}
