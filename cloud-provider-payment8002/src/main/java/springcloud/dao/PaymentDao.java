package springcloud.dao;

import com.atguigu.spring.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lpy
 * @Date: 2023/03/06
 */
@Mapper
public interface PaymentDao {
    Integer insert(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    List<Payment> queryAll(Payment payment);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Payment> queryAllByLimit(int offset, int limit);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
}
