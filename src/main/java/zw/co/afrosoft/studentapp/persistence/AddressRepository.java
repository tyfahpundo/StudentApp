package zw.co.afrosoft.studentapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.studentapp.domain.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
