package sergey.bychkov.kogdaigra.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sergey.bychkov.kogdaigra.model.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal,Long> {
}
