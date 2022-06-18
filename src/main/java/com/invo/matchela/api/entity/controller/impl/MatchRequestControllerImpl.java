package com.invo.matchela.api.entity.controller.impl;

import com.invo.matchela.api.entity.cards.MatchRequest;
import com.invo.matchela.api.entity.controller.MatchRequestController;
import com.invo.matchela.api.entity.dto.MatchRequestDTO;
import com.invo.matchela.api.entity.mapper.MatchRequestMapper;
import com.invo.matchela.api.entity.service.MatchRequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/match-request")
@RestController
public class MatchRequestControllerImpl implements MatchRequestController {
    private final MatchRequestService matchRequestService;
    private final MatchRequestMapper matchRequestMapper;

    public MatchRequestControllerImpl(MatchRequestService matchRequestService, MatchRequestMapper matchRequestMapper) {
        this.matchRequestService = matchRequestService;
        this.matchRequestMapper = matchRequestMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatchRequestDTO save(@RequestBody MatchRequestDTO matchRequestDTO) {
        MatchRequest matchRequest = matchRequestMapper.asEntity(matchRequestDTO);
        return matchRequestMapper.asDTO(matchRequestService.save(matchRequest));
    }

    @Override
    @GetMapping("/{id}")
    public MatchRequestDTO findById(@PathVariable("id") Long id) {
        MatchRequest matchRequest = matchRequestService.findById(id).orElse(null);
        return matchRequestMapper.asDTO(matchRequest);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        matchRequestService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<MatchRequestDTO> list() {
        return matchRequestMapper.asDTOList(matchRequestService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<MatchRequestDTO> pageQuery(Pageable pageable) {
        Page<MatchRequest> matchRequestPage = matchRequestService.findAll(pageable);
        List<MatchRequestDTO> dtoList = matchRequestPage
                .stream()
                .map(matchRequestMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, matchRequestPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public MatchRequestDTO update(@RequestBody MatchRequestDTO matchRequestDTO, @PathVariable("id") Long id) {
        MatchRequest matchRequest = matchRequestMapper.asEntity(matchRequestDTO);
        return matchRequestMapper.asDTO(matchRequestService.update(matchRequest, id));
    }
}