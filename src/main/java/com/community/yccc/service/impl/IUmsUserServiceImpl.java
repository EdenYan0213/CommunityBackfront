package com.community.yccc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.community.yccc.common.exception.ApiAsserts;
import com.community.yccc.jwt.JwtUtil;
import com.community.yccc.mapper.BmsFollowMapper;
import com.community.yccc.mapper.BmsTopicMapper;
import com.community.yccc.mapper.UmsUserMapper;
import com.community.yccc.model.dto.LoginDTO;
import com.community.yccc.model.dto.RegisterDTO;
import com.community.yccc.model.entity.BmsFollow;
import com.community.yccc.model.entity.BmsPost;
import com.community.yccc.model.entity.UmsUser;
import com.community.yccc.model.vo.ProfileVO;
import com.community.yccc.service.IUmsUserService;
import com.community.yccc.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class IUmsUserServiceImpl extends ServiceImpl<UmsUserMapper,
        UmsUser> implements IUmsUserService {

    @Autowired
    private BmsTopicMapper bmsTopicMapper;
    @Autowired
    private BmsFollowMapper bmsFollowMapper;

    @Override
    public UmsUser executeRegister(RegisterDTO dto) {
        //查询是否有相同用户名的用户
        LambdaQueryWrapper<UmsUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsUser::getUsername, dto.getName()).or().eq(UmsUser::getEmail, dto.getEmail());
        UmsUser umsUser = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(umsUser)) {
            ApiAsserts.fail("账号或邮箱已存在！");
        }
        //没找到同名的进行注册
        UmsUser user = new UmsUser();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getName());
        user.setPassword(MD5Utils.getPwd(dto.getPass()));
        user.setCreateTime(new Date());
        user.setAlias(dto.getName());
        user.setStatus(true);
        baseMapper.insert(user);//插入数据库

        return user;
    }

    @Override
    public UmsUser getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<UmsUser>().eq(UmsUser::getUsername, username));
    }
    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;
        try {
            UmsUser user = getUserByUsername(dto.getUsername());
            String encodePwd = MD5Utils.getPwd(dto.getPassword());
            if(!encodePwd.equals(user.getPassword()))
            {
                throw new Exception("密码错误");
            }
            token = JwtUtil.generateToken(String.valueOf(user.getUsername()));
        } catch (Exception e) {
            log.warn("用户不存在or密码验证失败=======>{}"+ dto.getUsername());
        }
        return token;
    }
    @Override
    public ProfileVO getUserProfile(String id) {
        ProfileVO profile = new ProfileVO();
        UmsUser user = baseMapper.selectById(id);
        BeanUtils.copyProperties(user, profile);
        // 用户文章数
        int count = bmsTopicMapper.selectCount(new LambdaQueryWrapper<BmsPost>().eq(BmsPost::getUserId, id));
        profile.setTopicCount(count);

        // 粉丝数
        int followers = bmsFollowMapper.selectCount((new LambdaQueryWrapper<BmsFollow>().eq(BmsFollow::getParentId, id)));
        profile.setFollowerCount(followers);

        return profile;
    }
}
