package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.datamodel.User;

// JPA Repository是关联背后的数据库，需要设置指定的datasource才能启动
public interface HomeRepository extends JpaRepository<User, Long> {
}
