
package com.goott.pj3.admin.controller;

import com.goott.pj3.admin.dto.NoticeDTO;
import com.goott.pj3.admin.service.AdminQnaService;
import com.goott.pj3.board.free.dto.FreeBoardDTO;
import com.goott.pj3.board.qna.dto.QnaDTO;
import com.goott.pj3.common.util.Criteria;
import com.goott.pj3.common.util.PagingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/**")
public class AdminQnaController {

    @Autowired
    AdminQnaService qnaService;

    /**
     * 신진영 23.04.19 리스트
     * @param mv
     * @param cri
     * @return
     */
    @RequestMapping("list")
    public ModelAndView qnaList(ModelAndView mv, Criteria cri) {
        PagingDTO paging = new PagingDTO();
        paging.setCri(cri); // page / perpagenum 설정
        paging.setTotalCount(qnaService.totalCount(cri)); // 총게시글 갯수 불러오는 것
        mv.addObject("paging", paging);
        mv.addObject("qnaList", qnaService.qnaList(cri));
        mv.setViewName("admin/qna/qnalist");
        return mv;
    }

    @RequestMapping("qnawrite")
    public String qnaCreate() {
        return "admin/qna/qnawrite";
    }

    @RequestMapping(value = "qnainsert", method = RequestMethod.POST)
    public String qnaInsert(QnaDTO dto, HttpSession session) {
        String user_id = (String) session.getAttribute("user_id");
        dto.setUser_id(user_id);
        qnaService.qnaInsert(dto);
        return "redirect:/admin/qnalist";
    }



    @RequestMapping("qnadetail/{qna_idx}")
    public ModelAndView qnaDetail(ModelAndView mv, @PathVariable int qna_idx) {
        mv.addObject("data", this.qnaService.qnaDetail(qna_idx));
        mv.setViewName("admin/qna/qnadetail");
        return mv;
    }

    @RequestMapping(value = "qnamodify", method = RequestMethod.POST, produces = "application/text; charset=UTF-8;")
    @ResponseBody
    public String qnaModify(QnaDTO dto) {
        qnaService.qnaModify(dto);
        return "수정완료";
    }

    //
    @RequestMapping("qnadelete")
    public String qnaDelete(int qna_idx) {
        qnaService.qnaDelete(qna_idx);
        return "redirect:/admin/qnalist";
    }



}