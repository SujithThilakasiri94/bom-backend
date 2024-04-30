package com.coconut_bom_backend.bom_backend.services.impls;

import com.coconut_bom_backend.bom_backend.dtos.requestDtos.RowItemRequestDto;
import com.coconut_bom_backend.bom_backend.entities.RowItem;
import com.coconut_bom_backend.bom_backend.repos.RowItemRepo;
import com.coconut_bom_backend.bom_backend.services.RowItemService;
import com.coconut_bom_backend.bom_backend.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RowItemServiceImpl implements RowItemService {

    private final ModelMapper mapper;
    private final RowItemRepo rowItemRepo;

    public RowItemServiceImpl(ModelMapper mapper, RowItemRepo rowItemRepo) {
        this.mapper = mapper;
        this.rowItemRepo = rowItemRepo;
    }

    @Override
    public StandardResponse saveRowItem(RowItemRequestDto dto) {

        StandardResponse response = new StandardResponse();
        RowItem existingItem = rowItemRepo.findByName(dto.getName());

        if (existingItem != null){
            response.setCode(400);
            response.setMessage("Name already exists");
            response.setData(existingItem);

    } else {
            try {
                //
                RowItem newRowItem = rowItemRepo.save(mapper.map(dto, RowItem.class));
                response.setCode(200);
                response.setMessage("Successfully saved row item");
                response.setData(newRowItem);
                response.setSuccess(true);
            }
            catch (Exception e){
                response.setCode(500);
                response.setMessage(e.getMessage());
                response.setData(null);
            }
        }
        return response;
    }

    @Override
    public StandardResponse removeRowItem(String id) {
        StandardResponse response = new StandardResponse();

        try {
            RowItem rowItem = rowItemRepo.findById(Integer.parseInt(id)).get();

            if (!rowItem.isDisabled()){
                try {
                    rowItem.setDisabled(true);
                    rowItemRepo.save(rowItem);

                    response.setCode(200);
                    response.setMessage("Row item successfully deleted");
                    response.setSuccess(true);
                }
                catch (Exception e){
                    response.setCode(500);
                    response.setMessage(e.getMessage());
                    response.setData(null);
                }
            }
            else {
                response.setCode(404);
                response.setMessage("Row item already deleted");
                response.setData(null);
            }
        }
        catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            response.setData(null);
        }
        return response;
    }
}
