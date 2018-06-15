package org.product.repository;

import java.util.List;

import org.product.jpaModel.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {
	
	@Query("Select e from AppRole e inner join e.userRoleCollection p "+
	"where p.userId.userId = :userId")
//	@Query("select * from AppRole")
	List<AppRole> getRoleNamesByUserId(@Param("userId") Long userId);

}
