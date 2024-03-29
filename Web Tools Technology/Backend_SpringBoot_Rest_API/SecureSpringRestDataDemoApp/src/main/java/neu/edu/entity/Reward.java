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
 * Reward generated by hbm2java
 */
@Entity
@Table(name = "reward", catalog = "crowdfunding")
public class Reward implements java.io.Serializable {

	private Integer rewardId;
	private Project project;
	private String text;
	private int minAmt;
	private Set<Funding> fundings = new HashSet<Funding>(0);

	public Reward() {
	}

	public Reward(Project project, int minAmt) {
		this.project = project;
		this.minAmt = minAmt;
	}

	public Reward(Project project, String text, int minAmt, Set<Funding> fundings) {
		this.project = project;
		this.text = text;
		this.minAmt = minAmt;
		this.fundings = fundings;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "reward_id", unique = true, nullable = false)
	public Integer getRewardId() {
		return this.rewardId;
	}

	public void setRewardId(Integer rewardId) {
		this.rewardId = rewardId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "min_amt", nullable = false)
	public int getMinAmt() {
		return this.minAmt;
	}

	public void setMinAmt(int minAmt) {
		this.minAmt = minAmt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reward")
	public Set<Funding> getFundings() {
		return this.fundings;
	}

	public void setFundings(Set<Funding> fundings) {
		this.fundings = fundings;
	}

}
