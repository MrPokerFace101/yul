package ru.yul.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yul.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from \"user\" where deviceid = :deviceId")
    User findByDeviceId(String deviceId);

    @Modifying
    @Query(nativeQuery = true, value = "insert into \"user\" (id, name, deviceid) values (:id, :name, :deviceId)")
    User save(Long id, String name, String deviceId);
}
