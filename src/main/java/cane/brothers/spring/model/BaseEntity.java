package cane.brothers.spring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@MappedSuperclass
public abstract class BaseEntity {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
        		.append(this.id)
        		.toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseEntity other = (BaseEntity) obj;
        return new EqualsBuilder()
        		.append(this.id, other.id)
        		.isEquals();
    }
}
