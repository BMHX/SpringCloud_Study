package top.zhijie.contentservice.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.zhijie.contentservice.Entity.Share;
import top.zhijie.contentservice.Entity.User;
import top.zhijie.contentservice.Mapper.ShareMapper;
import top.zhijie.contentservice.model.ShareVO;
import top.zhijie.contentservice.model.UserDTO;
import top.zhijie.contentservice.openfeign.UserClient;

@Service
@RequiredArgsConstructor
public class ShareService {
    private final ShareMapper shareMapper;
    private final UserClient userClient;

    public ShareVO getShareWithUser(Integer id) {
        Share share = shareMapper.selectById(Long.valueOf(id));
        System.out.println(share);
        User user = userClient.getUserById(share.getUser_id());
        System.out.println(user);
        UserDTO userDTO = new UserDTO(user.getId(), user.getUser_name(), user.getAvatar_url());
        return new ShareVO(share.getId(), share.getTitle(), share.getAuthor(), share.getCover(), share.getSummary(), share.getPrice(), userDTO);
    }
}
