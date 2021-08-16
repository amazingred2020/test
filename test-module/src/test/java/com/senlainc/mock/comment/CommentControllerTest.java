package com.senlainc.mock.comment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senlainc.controller.CommentController;
import com.senlainc.dto.comment.UpdateCommentRequest;
import com.senlainc.entity.Comment;
import com.senlainc.entity.Post;
import com.senlainc.entity.User;
import com.senlainc.routes.CommentRoutes;
import com.senlainc.service.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerTest {

    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentController commentController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    public void testAddComment() throws Exception {
        //AddCommentRequest request = new AddCommentRequest();
        //request.setUserId(1l);
        //request.setPostId(1l);
        //request.setContent("content");

        ObjectMapper objectMapper = new ObjectMapper();
        //String json = objectMapper.writeValueAsString(request);

        Comment comment = new Comment();
        comment.setContent("content");
        comment.setUser(new User());
        comment.setPost(new Post());

       // when(commentService.addComment(request)).thenReturn(comment);

      //  mockMvc.perform(post(CommentRoutes.COMMENT)
              //  .contentType(MediaType.APPLICATION_JSON)
          //      .content(json))
            //    .andExpect(status().isOk());

    }

    @Test
    public void testDeleteComment() throws Exception {
        doNothing().when(commentService).deleteComment(anyLong());

        //mockMvc.perform(delete(CommentRoutes.DELETE_COMMENT, anyLong()))
         //       .andExpect(status().isOk());

        verify(commentService, atLeast(1)).deleteComment(anyLong());
    }

    @Test
    public void testEditComment() throws Exception {
        UpdateCommentRequest request = new UpdateCommentRequest();
        request.setCommentId(1l);
        request.setContent("content");

        Comment comment = new Comment();
        comment.setId(1l);
        comment.setUpdatedAt(LocalDateTime.now());
        comment.setContent("content");
        comment.setUser(new User());
        comment.setPost(new Post());

        ObjectMapper objectMapper = new ObjectMapper();

        when(commentService.editComment(request)).thenReturn(comment);

        //mockMvc.perform(put(CommentRoutes.UPDATE_COMMENT)
          //      .accept(MediaType.APPLICATION_JSON)
            //    .content(objectMapper.writeValueAsString(request))
              //  .contentType(MediaType.APPLICATION_JSON))
                //.andExpect(status().is2xxSuccessful())
                //.andDo(MockMvcResultHandlers.print());
    }
}
