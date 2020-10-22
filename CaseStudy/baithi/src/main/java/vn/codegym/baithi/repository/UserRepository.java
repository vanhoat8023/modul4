package vn.codegym.baithi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.baithi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
