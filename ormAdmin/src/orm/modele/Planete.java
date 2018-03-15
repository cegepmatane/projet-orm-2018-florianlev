package orm.modele;

public class Planete {
	protected String nom;
	protected String etoile;
	protected String typeEtoile;
	protected String masse;
	protected String rayon;
	protected float flux;
	protected String temperature;
	protected float periode;
	protected float distance;
	protected String zone;
	protected float ist;
	protected float sph;
	protected float hzd;
	protected float hzc;
	protected float hza;
	protected String fClasse;
	protected String hClasse;
	protected String status;
	protected String decouverte;
	
	public Planete()
	{

	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEtoile() {
		return etoile;
	}
	public void setEtoile(String etoile) {
		this.etoile = etoile;
	}
	public String getTypeEtoile() {
		return typeEtoile;
	}
	public void setTypeEtoile(String typeEtoile) {
		this.typeEtoile = typeEtoile;
	}
	public String getMasse() {
		return masse;
	}
	public void setMasse(String masse) {
		this.masse = masse;
	}
	public String getRayon() {
		return rayon;
	}
	public void setRayon(String rayon) {
		this.rayon = rayon;
	}
	public float getFlux() {
		return flux;
	}
	public void setFlux(float flux) {
		this.flux = flux;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public float getPeriode() {
		return periode;
	}
	public void setPeriode(float periode) {
		this.periode = periode;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public float getIst() {
		return ist;
	}
	public void setIst(float ist) {
		this.ist = ist;
	}
	public float getSph() {
		return sph;
	}
	public void setSph(float sph) {
		this.sph = sph;
	}
	public float getHzd() {
		return hzd;
	}
	public void setHzd(float hzd) {
		this.hzd = hzd;
	}
	public float getHzc() {
		return hzc;
	}
	public void setHzc(float hzc) {
		this.hzc = hzc;
	}
	public float getHza() {
		return hza;
	}
	public void setHza(float hza) {
		this.hza = hza;
	}
	public String getfClasse() {
		return fClasse;
	}
	public void setfClasse(String fClasse) {
		this.fClasse = fClasse;
	}
	public String gethClasse() {
		return hClasse;
	}
	public void sethClasse(String hClasse) {
		this.hClasse = hClasse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDecouverte() {
		return decouverte;
	}
	public void setDecouverte(String decouverte) {
		this.decouverte = decouverte;
	}
}