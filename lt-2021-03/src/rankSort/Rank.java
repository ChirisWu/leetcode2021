package rankSort;

/**
 * @by ：chiris
 * @when ：Created in 2021-04-10
 */

public class Rank {
    private Integer star;
    private Integer rank;

    public Rank(Integer star, Integer rank) {
        this.star = star;
        this.rank = rank;
    }

    public Rank(Integer star) {
        this.star = star;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "star=" + star +
                ", rank=" + rank +
                '}';
    }
}
