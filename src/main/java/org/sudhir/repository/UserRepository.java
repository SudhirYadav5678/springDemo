package org.sudhir.repository;

import com.sudhir.stock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
