package com.hzlx.dao.impl;

import com.hzlx.dao.MenuInfoDao;
import com.hzlx.entity.MenuInfo;
import com.hzlx.utils.BaseDao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <h3>background-management-system</h3>
 * <p></p>
 *
 * @author : 李永富
 * @date : 2023-06-02 08:58
 **/
public class MenuInfoDaoImpl extends BaseDao<MenuInfo> implements MenuInfoDao {

    /**
     * 根据父级pid查询菜单集合
     * @param pid 父级id
     * @return
     */

    @Override
    public List<MenuInfo> getMenuInfoListByPid(Integer userId,Integer pid){
//        String sql = "select * from t_menu_info where `status`=1 and p_id=?";
        String sql = "select tmi.*\n" +
                "from t_menu_info tmi\n" +
                "left join t_menu_role_info tmri on tmri.menu_id=tmi.id\n" +
                "left join t_user_role_info turi  on turi.role_id=tmri.role_id\n" +
                "where turi.user_id=? and tmi.status=1 and tmi.p_id=?";
        return selectListForObject(sql,MenuInfo.class,userId,pid);
    }

    @Override
    public List<Map<String,Object>> getMenuAll() {
        String sql = "SELECT tmi1.*,tmi2.title as pName\n" +
                "FROM t_menu_info tmi1 \n" +
                "LEFT JOIN t_menu_info tmi2 on tmi2.id =tmi1.p_id";
        return selectListForMap(sql);
    }

    @Override
    public MenuInfo getMenuInfoById(Integer id) {
        String sql = "select * from t_menu_info where id=?";
        return selectOne(sql,MenuInfo.class,id);
    }

    @Override
    public int updateMenuInfoById(Integer id, String title, String icon, String href, Integer pId) {
        String sql = "update t_menu_info set title=?,icon=?,href=?,p_id=? where id=?";
        return executeUpdate(sql, title, icon, href, pId, id);
    }

    @Override
    public int deleteMenuInfoById(Integer id) {
        String sql = "update t_menu_info set `status`=0 where id=?";
        return executeUpdate(sql,id);
    }

    @Override
    public int addMenuInfo(String title, String icon, String href, Integer pId) {
        String sql = "insert into t_menu_info value(default,?,?,?,?,now(),default)";
        return executeUpdate(sql, title, icon, href, pId);
    }

}
