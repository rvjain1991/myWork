package neu.edu.entity;
// Generated 10 Dec, 2017 5:27:37 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Servicebid generated by hbm2java
 */
@Entity
@Table(name = "servicebid", catalog = "crowdfunding")
public class Servicebid implements java.io.Serializable {

	private Integer serviceBidId;
	private Service service;
	private Startup startup;
	private int bidAmt;
	private Integer isAssigned;
	private Set<Servicecompletion> servicecompletions = new HashSet<Servicecompletion>(0);

	public Servicebid() {
	}

	public Servicebid(Service service, Startup startup, int bidAmt) {
		this.service = service;
		this.startup = startup;
		this.bidAmt = bidAmt;
	}

	public Servicebid(Service service, Startup startup, int bidAmt, Integer isAssigned,
			Set<Servicecompletion> servicecompletions) {
		this.service = service;
		this.startup = startup;
		this.bidAmt = bidAmt;
		this.isAssigned = isAssigned;
		this.servicecompletions = servicecompletions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "service_bid_id", unique = true, nullable = false)
	public Integer getServiceBidId() {
		return this.serviceBidId;
	}

	public void setServiceBidId(Integer serviceBidId) {
		this.serviceBidId = serviceBidId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id", nullable = false)
	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "startup_id", nullable = false)
	public Startup getStartup() {
		return this.startup;
	}

	public void setStartup(Startup startup) {
		this.startup = startup;
	}

	@Column(name = "bid_amt", nullable = false)
	public int getBidAmt() {
		return this.bidAmt;
	}

	public void setBidAmt(int bidAmt) {
		this.bidAmt = bidAmt;
	}

	@Column(name = "is_assigned")
	public Integer getIsAssigned() {
		return this.isAssigned;
	}

	public void setIsAssigned(Integer isAssigned) {
		this.isAssigned = isAssigned;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "servicebid")
	public Set<Servicecompletion> getServicecompletions() {
		return this.servicecompletions;
	}

	public void setServicecompletions(Set<Servicecompletion> servicecompletions) {
		this.servicecompletions = servicecompletions;
	}

}
